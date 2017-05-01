public class Planet {

    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;


    public static void main(String[] args) {

    }


    public Planet(double xP, double yP, double xV, double yV, double m, String img) {

    xxPos = xP;
    yyPos = yP;
    xxVel = xV;
    yyVel = yV;
    mass = m;
    imgFileName = img;
    }



    public Planet(Planet p){



        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;

    }


    public double calcDistance(Planet p){

        double dX = Math.abs(this.xxPos - p.xxPos);
        double dY = Math.abs(this.yyPos - p.yyPos);


        double distance = Math.sqrt( (dX*dX) + (dY*dY) );

        return distance;

    }


    public double calcForceExertedBy(Planet p){

        double G = 6.67 * Math.pow(10,-11);


        double Force = (G * this.mass * p.mass) / (calcDistance(p) * calcDistance(p));



        return Force;

    }

    public double calcForceExertedByX(Planet p){

        double dX = Math.abs(this.xxPos - p.xxPos);

        double xForce = (calcForceExertedBy(p) * dX) / calcDistance(p);

        if (this.xxPos < p.xxPos)
            return xForce;

        else if (this.xxPos == p.xxPos) {
            xForce = 0.0;
            return xForce;
        }


            return xForce *= -1;
    }



    public double calcForceExertedByY(Planet p){

        double dY = Math.abs(this.yyPos - p.yyPos);

        double yForce = (calcForceExertedBy(p) * dY) / calcDistance(p);

        if (this.yyPos < p.yyPos)
            return yForce;


        else if (this.yyPos == p.yyPos) {
            yForce = 0.0;
            return yForce;
        }

        return yForce *= -1;
    }


    public double calcNetForceExertedByX(Planet [] allPlanets) {

        double xNetForce = 0;


        for (int x = 0; x < allPlanets.length; x++) {

            if (this.equals(allPlanets[x]) == false) {

                xNetForce += this.calcForceExertedByX(allPlanets[x]);

            }


        }

        return xNetForce;
    }



    public double calcNetForceExertedByY(Planet [] allPlanets){

        double yNetForce = 0;

        for (int y = 0; y < allPlanets.length; y++) {

            if (this.equals(allPlanets[y]) == false) {

                yNetForce += this.calcForceExertedByY(allPlanets[y]);

            }


        }

        return yNetForce;

    }


    public void update(double dT,int fX,int fY){
        double aX = fX / this.mass;
        double aY = fY / this.mass;

        this.xxVel = this.xxVel + (dT*aX);
        this.yyVel = this.yyVel + (dT*aY);

        this.xxPos = (this.xxPos + dT* this.xxVel);
        this.yyPos = (this.yyPos + dT* this.yyVel);


    }


} // Planet Class
