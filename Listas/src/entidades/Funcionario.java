package entidades;

public class Funcionario {

	private Integer id;
	private Double salario;
	private String nome;
	
	public Funcionario() {
		
	}

	public Funcionario(Integer id, Double salario, String nome) {
		super();
		this.id = id;
		this.salario = salario;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getSalary() {
		return salario;
	}

	public void setSalary(Double salary) {
		this.salario = salary;
	}

	public String getName() {
		return nome;
	}

	public void setName(String name) {
		this.nome = name;
	}
	
	public void aumentarSalario(double porcentagem) {
		salario += salario * porcentagem / 100;
	}
	
	public String toString() {
		return id + ", " +nome+ ", " +String.format("%.2f", salario)+ ", ";
	}
}