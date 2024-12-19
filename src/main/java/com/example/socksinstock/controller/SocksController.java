package com.example.socksinstock.controller;

import com.example.socksinstock.model.Socks;
import com.example.socksinstock.service.SocksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/socks")
public class SocksController {

    @Autowired
    private SocksService service;

    /**
     * Параметры: цвет носков, процентное содержание хлопка, количество.
     * Увеличивает количество носков на складе.
     * Регистрация отпуска носков:
     */
    @PostMapping("/income")
    @Operation(summary = "Регистрация и увеличение Носков")
    public ResponseEntity<?> registerIncome(@RequestBody Socks socks) {
        return ResponseEntity.ok(String.format("Регистрация %s прошла успешно", socks));
    }

    /**
     * Параметры: цвет носков, процентное содержание хлопка, количество.
     * Уменьшает количество носков на складе, если их хватает.
     */
    @PostMapping("/outcome")
    @Operation(summary = "Уменьшение носков")
    public ResponseEntity<?> registerOutcome(@RequestBody Socks socks) {
        return ResponseEntity.ok(String.format("Уменьшение %s прошла успешно", socks));
    }

    /**
     * Возвращает количество носков, соответствующих критериям.
     */
    @GetMapping
    @Operation(summary = "Возвращает кол-во носков")
    public ResponseEntity<?> getAllSocks() {
        return ResponseEntity.ok("Получены все данные о Носках");
    }

    /**
     * Позволяет изменить параметры носков (цвет, процент хлопка, количество).
     */
    @PutMapping("/{id}")
    @Operation(summary = "Изменение параметров носков")
    public ResponseEntity<?> updateSocks(@PathVariable Integer id) {
        return ResponseEntity.ok(String.format("Носки с $d изменены данные", id));
    }

    /**
     * Принимает Excel файл с партиями носков,
     * содержащими цвет, процентное содержание хлопка и количество.
     */
    @PostMapping("/batch")
    @Operation(summary = "Принимает Excel файл")
    public ResponseEntity<?> uploadBatch(@RequestParam("files") MultipartFile file) {
        return ResponseEntity.ok(String.format("Файл %s получен", file));
    }
}
