package modelo;

import java.util.Objects;

public class Departamento {

	private int codDepartamento;
	private int codCentro;
	private String tipoDir; 
	private int presupuesto;
	private String nombre;
	
	public Departamento() {
		this.codDepartamento = 0;
		this.codCentro = 0;
		this.tipoDir = "F";
		this.presupuesto = 0;
		this.nombre = "";
	}

	public Departamento(int codDepartamento, int codCentro,
			String tipoDir, int presupuesto, String nombre) {
		this.codDepartamento = codDepartamento;
		this.codCentro = codCentro;
		this.tipoDir = tipoDir;
		this.presupuesto = presupuesto;
		this.nombre = nombre;
	}

	public int getCodDepartamento() {
		return codDepartamento;
	}

	public void setCodDepartamento(int codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	public int getCodCentro() {
		return codCentro;
	}

	public void setCodCentro(int codCentro) {
		this.codCentro = codCentro;
	}

	public String getTipoDir() {
		return tipoDir;
	}
	
	public String getTipoDirTexto() {
		if(this.tipoDir.equals("P")) {
			return "En propiedad";
		}
		return "En funciones";
	}

	public void setTipoDir(String tipoDir) {
		this.tipoDir = tipoDir;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codDepartamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return codDepartamento == other.codDepartamento;
	}

	@Override
	public String toString() {
		return "Departamento [codDepartamento=" + codDepartamento + ", codCentro=" + codCentro + ", tipoDir=" + tipoDir
				+ ", presupuesto=" + presupuesto + ", nombre=" + nombre + "]";
	}
	
	
	
	
	
}
