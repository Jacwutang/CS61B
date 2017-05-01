public class NBody {

    public static double readRadius(String PlanetsTextFile){

        In in = new In(PlanetsTextFile);

        int n = in.readInt();

        double radius = in.readDouble();




        return radius;
    }



}
