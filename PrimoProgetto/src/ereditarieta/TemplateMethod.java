package ereditarieta;

import java.util.Arrays;

public class TemplateMethod {
	
	public static abstract class Sintetizzatore {
		public final double valore;
		public Sintetizzatore(double[] dati) {
			valore = sintesi(dati);
		}
		protected abstract double sintesi(double[] dati);
	}
	
	public static class Media extends Sintetizzatore{
		public Media(double[] dati) {
			super(dati);
		}

		@Override
		protected double sintesi(double[] dati) {
			double somma = 0;
			for(double x : dati) somma+=x;
			return somma / dati.length;
		}
	}
	
	public static class Mediana extends Sintetizzatore{
		public Mediana(double[] dati) {
			super(dati);
		}

		@Override
		protected double sintesi(double[] dati) {
			Arrays.sort(dati);
			if( dati.length % 2 == 0) {
				return (dati[dati.length/2] + dati[dati.length/2+1])/2;
			}else {
				return dati[dati.length/2];
			}
		}
	}

	public static void main(String[] args) {
		
		double dati[] = { 1.2, 3.4, 5.8, -1, 42, 3.14, 10.8};
		
		Sintetizzatore[] sintesi = {
				new Media(dati),
				new Mediana(dati)
		};
		
		for(Sintetizzatore s : sintesi)
			System.out.println(s.valore);

	}

}
