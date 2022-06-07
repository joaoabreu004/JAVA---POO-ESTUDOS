public enum EStatus {
	ATIVO("ativo"), INATIVO("inativo");
	
	protected String text; 
	private EStatus(String text){
		this.text = text; 
	}
}
