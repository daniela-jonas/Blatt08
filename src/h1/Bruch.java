package h1;

public class Bruch {
	public int zaehler;
	public int nenner;
	
	public Bruch(int zaehler, int nenner) {
		this.zaehler = zaehler;
		this.nenner = nenner;
	}
	
	private int ggT(int x, int y) {
		x = Math.abs(x);
		y = Math.abs(y);
		
		if (y>x) {
			int temp = x;
			x = y;
			y = temp;
		}
		
		while (y!= 0) {
			int r = x % y;
			x = y;
			y = r;
		}
		return x;
	}
	
	public void shorten() {
		int ggt = ggT(zaehler, nenner);
		
		if (ggt != 0) {
			zaehler /= ggt;
			nenner /= ggt;
		}
		
		if (nenner < 0) {
			nenner *= -1;
			zaehler *= -1;
		}
	}
	
	public boolean hasSameValueAs(Bruch b) {
		int thisZ = this.zaehler;
		int thisN = this.nenner;
		
		int bZ = b.zaehler;
		int bN = b.nenner;
		
		int g1 = ggT(thisZ, thisN);
		int g2 = ggT(bZ, bN);
		
		thisZ /= g1;
		thisN /= g1;
		
		bZ /= g2;
		bN /= g2;
		
		return (thisZ == bZ) && (thisN == bN);
		
		}

}
