package es.sd.PracticaSD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empleado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long empleadoid;
	
	private String nombre;
	private String apellidos;
	private String correo;
	private String movil;
	private String fijo;
	private String tipo;
	
	public Empleado(){
		
	}
	
	public Empleado(String nom, String ape, String correo,String movil,String fijo, String tipo){
		this.nombre=nom;
		this.apellidos=ape;
		this.correo=correo;
		this.movil=movil;
		this.fijo=fijo;
		this.tipo=tipo;
	}
	
	public void setNombre(String nom){
		this.nombre=nom;
	}
	public String getNombre(){
		return this.nombre;
	}
	public void setApellidos(String ape){
		this.apellidos=ape;
	}
	public String getApellidos(){
		return this.apellidos;
	}
	public void setCorreo(String correo){
		this.correo=correo;
	}
	public String getCorreo(){
		return this.correo;
	}
	public void setMovil(String movil){
		this.movil=movil;
	}
	public String getMovil(){
		return this.movil;
	}
	public void setTFijo(String fijo){
		this.fijo=fijo;
	}
	public String getFijo(){
		return this.fijo;
	}
	public void setTipo(String tipo){
		this.tipo=tipo;
	}
	public String getTipo(){
		return this.tipo;
	}
	public long getId(){
		return this.empleadoid;
	}
	
}
