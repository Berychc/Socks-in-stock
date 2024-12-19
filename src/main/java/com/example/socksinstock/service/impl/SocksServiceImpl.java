package com.example.socksinstock.service.impl;

import com.example.socksinstock.model.Socks;
import com.example.socksinstock.repository.SocksRepository;
import com.example.socksinstock.service.SocksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для управления Носками
 */
@Service
@Slf4j
public class SocksServiceImpl implements SocksService {

    @Autowired
    private SocksRepository repository;
    
    @Override
    public void registerIncome(Socks socks) {
        repository.save(socks);
        log.info("Приход носков: {}", socks);
    }

    @Override
    public void registerOutcome(Socks socks, Integer amount) {
        Optional<Socks> optionalSock = repository.findById(socks.getId());
        if (optionalSock.isPresent()) {
            Socks existingSock = optionalSock.get();
            if (existingSock.getAmount() >= amount) {
                existingSock.setAmount(existingSock.getAmount() - amount);
                repository.save(existingSock);
                log.info("Отпуск носков: {}", socks);
            } else {
                log.error("Недостаточно носков на складе: {}", socks);
                throw new RuntimeException("Недостаточно носков на складе");
            }
        } else {
            log.error("Носки не найдены: {}", socks);
            throw new RuntimeException("Носки не найдены");
        }
    }

    public List<Socks> getSocks(String color, String comparisonOperator, Integer cottonPercentage) {
        // Логика фильтрации носков
        log.info("Получение носков с фильтрацией: цвет={}, оператор={}, хлопок={}", color, comparisonOperator, cottonPercentage);
        return repository.filterSocks(color, comparisonOperator, cottonPercentage);
    }

    public void updateSock(Integer id, Socks updatedSock) {
        Optional<Socks> optionalSock = repository.findById(id);
        if (optionalSock.isPresent()) {
            Socks sock = optionalSock.get();
            sock.setSocksColor(updatedSock.getSocksColor());
            sock.setCottonPercentage(updatedSock.getCottonPercentage());
            sock.setAmount(updatedSock.getAmount());
            repository.save(sock);
            log.info("Обновление данных носков: {}", sock);
        } else {
            log.error("Носки не найдены для обновления: {}", id);
            throw new RuntimeException("Носки не найдены");
        }
    }

    public void batchUpload(MultipartFile file) {
        // Логика загрузки партий носков из файла (CSV или Excel)
        log.info("Загрузка партий носков из файла: {}", file.getOriginalFilename());
        // Обработка файла и сохранение в базу данных
    }

    // Дополнительные методы, такие как фильтрация по диапазону, сортировка и т.д.
}

