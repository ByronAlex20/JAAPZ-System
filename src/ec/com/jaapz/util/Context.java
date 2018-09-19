package ec.com.jaapz.util;

import java.sql.Connection;

import ec.com.jaapz.modelo.Rubro;
import ec.com.jaapz.modelo.SegUsuario;
/*import ec.com.jaapz.modelo.JunAperturaLectura;
import ec.com.jaapz.modelo.JunContribuyentes;
import ec.com.jaapz.modelo.JunCuentaCliente;*/
import javafx.stage.Stage;

public class Context {
	private final static Context instance = new Context();
	
	Connection conexion = null;
	private String usuario;
	private String perfil;
	private int idUsuario;
	private int idPerfil;
	
	private Stage stage;
	private Stage stageModal;
	private SegUsuario usuarios;
	private SegUsuario usuariosC;
	private Rubro rubros;
	
	//private JunPlanilla planillas;
	//private JunCliente cliente;
	//private JunCuentaCliente cuentaCliente;
	//private JunCategoria categoria;
	//private JunBarrio barrio;
	//private List<JunInspeccionNuevoCliente> listaInspecciones;
	
	//private JunInspeccionNuevoCliente ordenInspeccion;
	
	public static Context getInstance() {
		return instance;
	}
	public Rubro getRubros() {
		return rubros;
	}
	
	public void setRubros(Rubro rubros) {
		this.rubros = rubros;
	}
	
	public Connection getConexion() {
		return conexion;
	}
	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	public Stage getStageModal() {
		return stageModal;
	}
	public void setStageModal(Stage stageModal) {
		this.stageModal = stageModal;
	}
	public SegUsuario getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(SegUsuario usuarios) {
		this.usuarios = usuarios;
	}
	public SegUsuario getUsuariosC() {
		return usuariosC;
	}
	public void setUsuariosC(SegUsuario usuariosC) {
		this.usuariosC = usuariosC;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
}