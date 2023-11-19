/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.tr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "horario")
public class Horario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHorario;

    @JsonIgnoreProperties(value = {"listaHorarios"})
    @ManyToOne
    @JoinColumn(
            name = "id_detalle_actividad",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_horario_detalle_actividad")
    )
    private DetalleActividad detalleActividad;

    @NotNull(message = "El campo: titulo, no debe ser nulo")
    @NotEmpty(message = "El campo: titulo, no debe ser vacio")
    @Size(min = 5, max = 80, message = "El campo: titulo, debe de tener como minimo 5 caracteres y como máximo 8")
    @Column(name = "titulo", nullable = false, length = 80)
    private String titulo;

    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "El campo: hora inicio, no debe ser nulo")
    @Column(nullable = false)
    private LocalTime horaInicio;

    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "El campo: hora fin, no debe ser nulo")
    @Column(nullable = false)
    private LocalTime horaFin;

    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "El campo: dia inicio, no debe ser nulo")
    @Column(nullable = false)
    private LocalDate diaInicio;

    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "El campo: dia fin, no debe ser nulo")
    @Column(nullable = false)
    private LocalDate diaFin;

    @NotNull(message = "El campo: dia completo, no debe ser nulo")
    @Column(name = "dia_completo", nullable = false)
    private boolean diaCompleto;

    @NotNull(message = "El campo: estado, no debe ser nulo")
    @Column(name = "estado", nullable = false)
    private boolean estado;

    //Constructor
    public Horario() {

    }

    //TODO: metodos
    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public DetalleActividad getDetalleActividad() {
        return detalleActividad;
    }

    public void setDetalleActividad(DetalleActividad detalleActividad) {
        this.detalleActividad = detalleActividad;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public LocalDate getDiaInicio() {
        return diaInicio;
    }

    public void setDiaInicio(LocalDate diaInicio) {
        this.diaInicio = diaInicio;
    }

    public LocalDate getDiaFin() {
        return diaFin;
    }

    public void setDiaFin(LocalDate diaFin) {
        this.diaFin = diaFin;
    }

    public boolean isDiaCompleto() {
        return diaCompleto;
    }

    public void setDiaCompleto(boolean diaCompleto) {
        this.diaCompleto = diaCompleto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Metodo que devolvera todos los eventos que se tendran que realizar
     * durante una fecha de inicio y fin Ademas, se tendra en cuenta las horas
     * fin e inicio entre ese lapso de fecha establecido Esto con el fin de que
     * en las fechas intermedias no se cubran de todo el evento en el
     * FullCalendar.
     *
     * @return
     */
    public List<Map<String, Object>> getEvents() {

        List<Map<String, Object>> listaEventos = new ArrayList<>();

        /**
         * Da diferencia de dias entre una fecha inicio y otra final EJP:
         * diaInicio = 2023-10-02 diaFin = 2023-10-04 numeroDias = 2 dias de
         * diferencia
         */
        long numeroDiasDiferencia = ChronoUnit.DAYS.between(diaInicio, diaFin);
        //LocalDate auxDate = this.diaInicio;

        /**
         * Logica para sacar cada evento entre los dias establecidos de inicio a
         * fin, con horas especificas. Se empezara de 0, por que la logica
         * comenzara a agregar dias con el .plusDay(i). Se terminara hasta la
         * diferencia de dias, por la logica de agregar dias. Se consideraran
         * los eventos desde el dia de inicio hasta el dia final, por eso es esa
         * condicional en el for(...)
         */
        for (long i = 0; i <= numeroDiasDiferencia; i++) {
            Map<String, Object> evento = new HashMap<>();
            evento.put("titulo", this.titulo);

            /**
             * Se empieza del dia inicio, por ende, la primera iteracion le
             * supara 0 dias En la ultima iteracion a la fecha inicio se le dara
             * el numero de dias de diferencia EJP: diaInicio = 2023-10-02
             * diaFin = 2023-10-04 numeroDiasDiferencia = 2 en la ultima
             * iteracion i = 2 por ende: LocalDate dia =
             * this.diaInicio.plusDays(2); -> dia = 2023-10-02 + 2 dias =
             * 2023-10-04
             */             
            //El .plusDays(i) no muta a this.diaInicio, pues los LocalDate-Time no son mutables, se crean nuevos objetos
            LocalDate dia = this.diaInicio.plusDays(i);

            //se establece el inicio y fin de un evento, para el mismo dia, con las horas de inicio y fin especificadas
            evento.put("start", LocalDateTime.of(dia, this.horaInicio));
            evento.put("end", LocalDateTime.of(dia, this.horaFin));

            listaEventos.add(evento);
        }

        return listaEventos;
    }

}
