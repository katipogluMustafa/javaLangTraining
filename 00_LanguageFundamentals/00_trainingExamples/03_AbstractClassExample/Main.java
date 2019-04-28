
public class Main {

	public static void main(String[] args) {
		Child ahmet = new Child("Ahmet K���k",5); //5 ayl�k
		Toy lego = new Toy("123456","Lego Star Wars",4); //4 ya�
		Clothing pinny = new Clothing("86978945","mama �nl���",0,24); //0-24 ay
		if( lego.isSuitable(ahmet) )
			System.out.println("Deneme 1 hatal�");
		else
			System.out.println("Deneme 1 tamam");
		if( pinny.isSuitable(ahmet) )
			System.out.println("Deneme 2 tamam");
		else
			System.out.println("Deneme 2 hatal�");
		Kindergarten yuva = new Kindergarten(2);
		if( yuva.addChild(ahmet) )
			System.out.println("Deneme 3 tamam");
		else
			System.out.println("Deneme 3 hatal�");
		if( yuva.findChild("AHMET K���K") == ahmet )
			System.out.println("Deneme 4 tamam");
		else
			System.out.println("Deneme 4 hatal�");
		if( yuva.findChild("Yunus Sel�uk") == null )
			System.out.println("Deneme 5 tamam");
		else
			System.out.println("Deneme 5 hatal�");
		yuva.addChild( new Child("Ay�e Minik",24) );
		if( yuva.addChild( new Child("Zeki �al��kan",28) ) )
			System.out.println("Deneme 7 hatal�");
		else
			System.out.println("Deneme 7 tamam");
		yuva.setCapacity(5);	
		if( yuva.findChild("AHMET K���K") == ahmet )
			System.out.println("Deneme 6 tamam");
		else
			System.out.println("Deneme 6 hatal�");
		
	}

}
