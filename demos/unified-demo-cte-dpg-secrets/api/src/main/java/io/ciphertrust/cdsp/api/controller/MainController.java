package io.ciphertrust.cdsp.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.ciphertrust.cdsp.api.bean.GetHealthDataResponseBean;
import io.ciphertrust.cdsp.api.bean.GetPaymentDataResponseBean;
import io.ciphertrust.cdsp.api.model.HealthData;
import io.ciphertrust.cdsp.api.model.PaymentData;
import io.ciphertrust.cdsp.api.repository.HealthDataRepo;
import io.ciphertrust.cdsp.api.repository.PaymentDataRepo;
import io.ciphertrust.cdsp.api.service.UploadService;

/**
 * @author Anurag Jain, developer advocate Thales Group
 *
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    HealthDataRepo healthDataRepo;

    @Autowired
    PaymentDataRepo paymentDataRepo;

    @Autowired
	UploadService uploadService;

    @PostMapping("/payment-info")
	public ResponseEntity<PaymentData> createRecordPCI(@RequestBody PaymentData data) {
		try {
			PaymentData _responseData = paymentDataRepo.save(data);
			return new ResponseEntity<>(_responseData, 
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, 
				HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @PostMapping("/health-info")
	public ResponseEntity<HealthData> createRecordPHI(
        @RequestParam("file") MultipartFile file,
        @RequestParam("name") String name,
        @RequestParam("cc") String cc,
        @RequestParam("cvv") String cvv,
        @RequestParam("expiry") String expiry,
        @RequestParam("zip") String zip) {
		try {
			String fileName = uploadService.saveAttachment(file);
            
            HealthData input = new HealthData();
            input.setName(name);
            input.setCc(cc);
            input.setCvv(cvv);
            input.setExpiry(expiry);
            input.setZip(zip);
            input.setFileName(fileName);

            HealthData _responseData = healthDataRepo.save(input);
			return new ResponseEntity<>(_responseData, 
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, 
				HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @GetMapping("/health-info")
	public ResponseEntity<GetHealthDataResponseBean> getRecordsPHI() {
		try {
            List<HealthData> records = new ArrayList<HealthData>();
			records = healthDataRepo.findAll();
            GetHealthDataResponseBean response = new GetHealthDataResponseBean(records);
            return new ResponseEntity<>(response, 
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, 
				HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @GetMapping("/payment-info")
	public ResponseEntity<GetPaymentDataResponseBean> getRecordsPCI() {
		try {
            List<PaymentData> records = new ArrayList<PaymentData>();
			records = paymentDataRepo.findAll();
            GetPaymentDataResponseBean response = new GetPaymentDataResponseBean(records);
            return new ResponseEntity<>(response, 
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, 
				HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
