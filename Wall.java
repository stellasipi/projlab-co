package shokoban;

public class Wall extends Coloumn {
	//Kukucs
    public void Accept (Object o, Direction d){
        //bemegyünk a fgv-be
        System.out.println(">");
        System.out.println("  ");
        System.out.println("[:Wall].Accept(object, dir):");

        if (this.getObject() != null)
        o.push(o, d);

        o.visit(this, d);
        this.Remove(o);

        //visszatérünk a fgv-ből
        System.out.println("<");
        System.out.println("  ");
        System.out.println("[:Wall].Accept(object, dir):");
    }
}
