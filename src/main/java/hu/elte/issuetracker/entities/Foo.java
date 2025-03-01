/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.issuetracker.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author KeresztiKrisztián
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Foo implements Serializable {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  @javax.persistence.Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(unique = true)
  @NotNull
  private String name;

  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime created_at;

  @Column
  @UpdateTimestamp
  private LocalDateTime updated_at;

public void setId(Integer id2) {
  this.id = id2;
}
}
