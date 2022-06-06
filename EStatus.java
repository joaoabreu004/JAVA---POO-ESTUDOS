public enum EStatus {
	ATIVO("ativo"), INATIVO("inativo");
	
	public static EStatus StatusAux;
	protected String text; 
	private EStatus(String text){
		this.text = text; 
	}
}
