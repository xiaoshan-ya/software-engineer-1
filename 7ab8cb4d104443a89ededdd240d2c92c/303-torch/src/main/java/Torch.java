public class Torch extends Battery{
    //add attributes for torch
    double crate = getConsumptionRate();
    double prate = getProductionRate();
    Battery battery1 = new Battery(crate,prate);
    double mye = battery1.e;
    public Torch(Battery battery){
        //add code here

    }

    /**
     * 10% power consumption per hour for using a torch
     * return true if enough power
     * return false if battery cannot support for the specified hours
     */
    public boolean turnOn(int hours){
        //add code here;
        double e = hours * crate;
        if (useBattery(hours * crate)){
            return false;
        }
        else{
            return true;
        }
    }
    /**
     * 20% power production per hour for charging the battery
     */
    public void charge(int hours){
        //add code here
        chargeBattery(hours * prate);
        mye = battery1.e;
    }

}
