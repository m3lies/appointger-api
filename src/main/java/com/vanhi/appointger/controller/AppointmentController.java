package com.vanhi.appointger.controller;

import com.vanhi.appointger.model.Appointment;
import com.vanhi.appointger.model.Response;
import com.vanhi.appointger.service.AppointServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointServiceImplementation appointmentServiceImpl;

    @GetMapping("/list")
    public ResponseEntity<Response> getAppointments(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("appointments", appointmentServiceImpl.list(30)))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Appointments retrieved")
                        .build()
        );
    }
    @PostMapping ("/save")
    public ResponseEntity<Response> saveAppointment(@RequestBody @Valid Appointment appointment){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("appointments", appointmentServiceImpl.create(appointment)))
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Appointment created")
                        .build()
        );
    }

    @GetMapping ("/get/{id}")
    public ResponseEntity<Response> getAppointment(@PathVariable Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("appointments", appointmentServiceImpl.get(id)))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Appointment retrieved")
                        .build()
        );
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Response> deleteAppointment(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("appointments", appointmentServiceImpl.delete(id)))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Appointment retrieved")
                        .build()
        );
    }
}