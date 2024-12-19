package com.example.socksinstock.model;

import lombok.*;
import javax.persistence.*;

/**
 * Модель Носков, представляющая сущность 'Socks' в базе данных.
 * Содержит информацию о цвете, включая идентификатор,
 * процентное содержание хлопка и количество.
 */

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "socks")
public class Socks {

    /**
     * Уникальный идентификатор носков.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Цвет носков
     */
    @Column(name = "color")
    private String socksColor;

    /**
     * Процентное содержание хлопка
     */
    @Column(name = "cotton")
    private Integer cottonPercentage; // Либо использовать Double для точных процентов

    /**
     * Количество
     */
    @Column(name = "amount")
    private Integer amount;
}
