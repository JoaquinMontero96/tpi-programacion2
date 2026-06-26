/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integrado.prog2.entities;

import java.time.LocalDateTime;

/**
 * Clase base
 * @author JOAQUIN
 */
public abstract class Base {
    private long id; /** ID de la entidad */
    private boolean eliminado; /** Estado de eliminacion */
    private LocalDateTime createdAt; /** Fecha y hora de creacion */

    public Base(long id, boolean eliminado, LocalDateTime createdAt) {
        this.id = id;
        this.eliminado = eliminado;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public boolean isEliminado() {
        return eliminado;
    }
}
