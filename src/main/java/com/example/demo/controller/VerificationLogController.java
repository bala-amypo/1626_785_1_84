// package com.example.demo.controller;

// import com.example.demo.model.VerificationLog;
// import com.example.demo.service.VerificationLogService;
// import java.util.List;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping("/api/verification-logs")
// public class VerificationLogController {

//     private final VerificationLogService logService;

//     public VerificationLogController(VerificationLogService logService) {
//         this.logService = logService;
//     }

//     @PostMapping
//     public ResponseEntity<VerificationLog> createLog(@RequestBody VerificationLog log) {
//         VerificationLog saved = logService.createLog(log);
//         return new ResponseEntity<>(saved, HttpStatus.CREATED);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<VerificationLog> getLogById(@PathVariable Long id) {
//         return ResponseEntity.ok(logService.getLogById(id));
//     }

//     @GetMapping("/entry/{entryId}")
//     public ResponseEntity<List<VerificationLog>> getLogsForEntry(@PathVariable Long entryId) {
//         return ResponseEntity.ok(logService.getLogsForEntry(entryId));
//     }
// }
