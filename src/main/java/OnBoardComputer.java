public class OnBoardComputer implements BurnStream {
    Boolean freefall = true;
    @Override
    public int getNextBurn(DescentEvent status) {
        int burn = 0;
        if (status.getVelocity() <= 0) burn = 99 - status.getVelocity();
        else if (status.getVelocity() < 3) burn = 100; // hold until landing
        else if (status.getVelocity() == 3) burn = 101; // stabilize at 2 velocity
        else if (status.getAltitude() < status.getVelocity() * 10) {
            if (status.getVelocity() / 4 > 100) {
                burn = 200;
            } else {
                burn = 100 + (status.getVelocity() / 4);
            }
            freefall = false;
        } else if (!freefall) {
            burn = 100;
        }
        System.out.println(burn); /*hack!*/
        return burn;
    }

}
