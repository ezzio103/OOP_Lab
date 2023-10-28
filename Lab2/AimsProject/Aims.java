package Lab2.AimsProject;

public class Aims {

        public static void main(String[] args) {
            DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion", "Animation","Roger Allers",87,19.95f);
            DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
            DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
			Cart anOrder = new Cart();


            anOrder.addDigitalVideoDisc(dvd1);
            anOrder.addDigitalVideoDisc(dvd2);
			anOrder.addDigitalVideoDisc(dvd3);
			anOrder.totalCost();
			anOrder.removeDigitalVideoDisc(dvd2);
            
			anOrder.removeDigitalVideoDisc(dvd3);
            anOrder.totalCost();
			
			 DigitalVideoDisc[] itemOrdered2 = new DigitalVideoDisc[2];
            itemOrdered2[0]=dvd2;
            itemOrdered2[1]=dvd3;
            anOrder.addDigitalVideoDisc(itemOrdered2);
            anOrder.totalCost();
			
			anOrder.removeDigitalVideoDisc(dvd2);
            
			anOrder.removeDigitalVideoDisc(dvd3);
			anOrder.totalCost();
			
			 anOrder.addDigitalVideoDisc(dvd2,dvd3);
			 anOrder.totalCost();
        }
    
}
