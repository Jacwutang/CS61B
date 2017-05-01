public class NBody {

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dT = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);

        Planet[] planets = readPlanets(filename);

    }





    public static double readRadius(String PlanetsTextFile){

        In in = new In(PlanetsTextFile);

        int n = in.readInt();

        double radius = in.readDouble();

        return radius;
    }

    public static Planet[] readPlanets(String PlanetsTextFile ) {

        In in = new In(PlanetsTextFile);

        int n = in.readInt();

        in.readDouble();

        Planet[] planets = new Planet[n];

        //Planet p1 = new Planet(xxPos,yyPos,xxVel,yyVel,planetName);


        for (int x = 0; x < n; x++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String planetName = in.readString();


            planets[x] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, planetName);


        } // for loop

        return planets;

    } // readPlanets

}
