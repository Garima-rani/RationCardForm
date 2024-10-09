//package com.example.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.model.UserRequest; // Ensure you have this class
//import com.example.service.MasterDataService;
//import com.example.service.UserService;
//
//@RestController
//@RequestMapping("/admin")
//public class AdminController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private MasterDataService masterDataService;
//
//    @GetMapping("/requests")
//    public ResponseEntity<List<UserRequest>> getPendingRequests() {
//        List<UserRequest> requests = userService.getPendingRequests();
//        return ResponseEntity.ok(requests);
//    }
//
//    @PostMapping("/approve")
//    public ResponseEntity<String> approveRequest(@RequestParam Long requestId) {
//        userService.approveRequest(requestId);
//        return ResponseEntity.ok("Request Approved");
//    }
//
//    @PostMapping("/decline")
//    public ResponseEntity<String> declineRequest(@RequestParam Long requestId) {
//        userService.declineRequest(requestId);
//        return ResponseEntity.ok("Request Declined");
//    }
//
////    @PatchMapping("/master-table/{id}/status")
////    public ResponseEntity<String> changeStatus(@PathVariable Long id, @RequestParam String status) {
////        masterDataService.changeStatus(id, status);
////        return ResponseEntity.ok("Status Updated");
////    }
//}
