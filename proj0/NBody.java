public class NBody {

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dT = Double.parseDouble(args[1]);

        String filename = args[2];
        double radius = readRadius(filename);


        int size = readSize(filename);


        String imageToDraw = "./images/starfield.jpg";

        Planet[] planets = readPlanets(filename);

        StdDraw.setScale(-radius,radius);


        double time = 0;
        int x = 0;

        for (time = 0; time <= T; time += dT){

            for(x = 0; x < size; x++){

                double xForces [] = new double[size];
                double yForces [] = new double[size];

                xForces[x] = planets[x].calcNetForceExertedByX(planets);
                yForces[x] = planets[x].calcNetForceExertedByY(planets);

                planets[x].update(dT,xForces[x],yForces[x]);
            }

            StdDraw.picture(-100,100,imageToDraw);

            for(int y = 0; y < size; y++){
                planets[y].draw();
            }

            StdDraw.show(10);

        }




    } // main

    public static int readSize(String PlanetsTextFile){

        In in = new In(PlanetsTextFile);

        int n = in.readInt();



        return n;
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
