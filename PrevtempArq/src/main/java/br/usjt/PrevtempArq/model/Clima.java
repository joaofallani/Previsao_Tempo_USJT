package br.usjt.PrevtempArq.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;

@Entity
@Table(name = "tb_clima")
@Getter @Setter 
@NamedQuery(query = "select p from Clima p inner join p.cidade c where c.id = p.id and upper(c.nome) = upper(:nome)",
        name = "Clima.BuscaPeloCidadeNome")
@NamedQuery(query = "select p from Clima p inner join p.cidade c where c.id = p.id and c.latitude = :latitude and c.longitude = :longitude",
        name = "Clima.BuscaPeloLatELon")
public class Clima implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clima")
    private Long id;

//    private String diaDaSemana;
    
    //Ligação 1 para 1
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "id_semana")
    private DiaSemana diaSemana;

    @Column(name = "tempmin_tempo")
    private Double temperaturaMin;
    @Column(name = "tempmax_tempo")
    private Double temperaturaMax;
    @Column(name = "humidade_tempo")
    private Double humidade;
    @Column(name = "datahora_tempo")
    private String dataHora;
    @Column(name = "desc_tempo")
    private String discricao;
    
    
    //Ligação N to 1
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "id_cidade")
    private Cidade cidade;
    
    
    //ToString
    @Override
    public String toString() {
        return diaSemana.getDia() + " "
                + "Temperatura minima: " + getTemperaturaMin() + "ºC "
                + "Temperatura maxima: " + getTemperaturaMax() + "ºC "
                + "Humidade: " + getHumidade() + "%";
    }
}
