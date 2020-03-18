package exposed.assignment.controller;

import exposed.assignment.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/dmv/")
@CrossOrigin
public class VerificationController {

    @Autowired
    private VerificationService verificationService;

    @GetMapping("/verifyId/{id}")
    public ResponseEntity<?> verifyId(@PathVariable String id) throws IOException {
        String isVerified = verificationService.verifyFromCSV(id);
        return new ResponseEntity<>(isVerified, HttpStatus.OK);
    }
}
