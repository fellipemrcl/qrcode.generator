package com.fellipe.qrcode.generator.controller;

import com.fellipe.qrcode.generator.dto.QrCodeGenerateRequest;
import com.fellipe.qrcode.generator.dto.QrCodeGenerateResponse;
import com.fellipe.qrcode.generator.service.QrCodeGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Qr code controller.
 */
@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    /**
     * Generate qr code response entity.
     *
     * @param request the request
     * @return the response entity
     */
    private final QrCodeGeneratorService qrCodeGeneratorService;

    public QrCodeController(QrCodeGeneratorService qrCodeGeneratorService) {
        this.qrCodeGeneratorService = qrCodeGeneratorService;
    }

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generateQrCode(@RequestBody QrCodeGenerateRequest request) {
        try {;
            QrCodeGenerateResponse response = qrCodeGeneratorService.generateAndUploadQrCode(request.text());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
