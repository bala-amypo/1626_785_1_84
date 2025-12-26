// package com.example.demo.service.impl;

// import com.example.demo.model.ServiceEntry;
// import com.example.demo.model.VerificationLog;
// import com.example.demo.repository.ServiceEntryRepository;
// import com.example.demo.repository.VerificationLogRepository;
// import com.example.demo.service.VerificationLogService;
// import jakarta.persistence.EntityNotFoundException;
// import java.sql.Timestamp;
// import java.time.Instant;
// import java.util.List;
// import org.springframework.stereotype.Service;

// @Service
// public class VerificationLogServiceImpl implements VerificationLogService {

//     private final VerificationLogRepository logRepo;
//     private final ServiceEntryRepository entryRepo;

//     public VerificationLogServiceImpl(VerificationLogRepository logRepo, ServiceEntryRepository entryRepo) {
//         this.logRepo = logRepo;
//         this.entryRepo = entryRepo;
//     }

//     @Override
//     public VerificationLog createLog(VerificationLog log) {

//         if (log == null || log.getServiceEntry() == null || log.getServiceEntry().getId() == null) {
//             throw new IllegalArgumentException("ServiceEntry not found");
//         }

//         ServiceEntry entry = entryRepo.findById(log.getServiceEntry().getId())
//                 .orElseThrow(() -> new EntityNotFoundException("ServiceEntry not found"));

//         log.setServiceEntry(entry);

//         if (log.getVerifiedAt() == null) {
//             log.setVerifiedAt(Timestamp.from(Instant.now()));
//         }

//         if (log.getVerifiedBySystem() == null) {
//             log.setVerifiedBySystem(true);
//         }

//         return logRepo.save(log);
//     }

//     @Override
//     public VerificationLog getLogById(Long id) {
//         return logRepo.findById(id)
//                 .orElseThrow(() -> new EntityNotFoundException("VerificationLog not found"));
//     }

//     @Override
//     public List<VerificationLog> getLogsForEntry(Long entryId) {
//         return logRepo.findByServiceEntryId(entryId);
//     }
// }
