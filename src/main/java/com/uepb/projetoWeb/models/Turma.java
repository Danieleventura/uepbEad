package com.uepb.projetoWeb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "turma")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String nome;
	
	@Column
	private String horario;
	
	
	@Column
	private int idProfessor;
	
	@Column
	private String codigo;

	
	//@OneToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
   // @JoinColumn(name = "fk_professor_id", foreignKey = @ForeignKey(name = "fk_professor"), referencedColumnName = "id")
	//private Usuario professorResponsavel;
	
	
	
	//@OneToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
   // @JoinTable(name = "lista_avaliacao", 
    		//	joinColumns={@JoinColumn(name="fK_turma_id", foreignKey = @ForeignKey(name = "fk_turma"), referencedColumnName = "id")},
    		//	inverseJoinColumns={@JoinColumn(name="fk_avaliacao_id", foreignKey = @ForeignKey(name = "fk_avaliacao"), referencedColumnName = "id")})
	//private List<Avaliacao> avaliacao;
	
	//@OneToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
   // @JoinTable(name = "lista_conteudo", 
    //			joinColumns={@JoinColumn(name="fK_turma_id", foreignKey = @ForeignKey(name = "fk_turma"), referencedColumnName = "id")},
    //			inverseJoinColumns={@JoinColumn(name="fk_conteudo_id", foreignKey = @ForeignKey(name = "fk_conteudo"), referencedColumnName = "id")})
	//private List<Conteudo> conteudo;
}
