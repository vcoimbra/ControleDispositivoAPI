package br.com.evrapevi.ControleDispositivo.util;

public enum EnumRetornoLogin {
	
	USUARIO_AUTENTICADO(0),
	USUARIO_NAO_AUTORIZADO(-1),
	USUARIO_CADASTRADO(1),
	USUARIO_EXISTENTE(-2);
	
	private EnumRetornoLogin(final Integer val){
		this.valor = val;
	}
	
	private Integer valor;

	public Integer getValor() {
		return valor;
	}
}
