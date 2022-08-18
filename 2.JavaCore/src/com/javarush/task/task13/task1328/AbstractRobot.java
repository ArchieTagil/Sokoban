package com.javarush.task.task13.task1328;

import com.sun.xml.internal.ws.wsdl.writer.document.soap.Body;

public abstract  class AbstractRobot implements Attackable, Defensable {
    private static int hitCount;
    private int bodyPartIndex;

    public BodyPart attack() {
        bodyPartIndex = (int) (Math.random() * 4);
        BodyPart attackedBodyPart = null;
        hitCount = hitCount + 1;

        switch (bodyPartIndex) {
            case 0:
                attackedBodyPart = BodyPart.ARM;
                break;
            case 1:
                attackedBodyPart = BodyPart.CHEST;
                break;
            case 2:
                attackedBodyPart = BodyPart.HEAD;
                break;
            case 3:
                attackedBodyPart = BodyPart.LEG;
                break;
        }
        return attackedBodyPart;
    }

    public BodyPart defense() {
        bodyPartIndex = (int) (Math.random() * 4);
        BodyPart defendedBodyPart = null;
        hitCount = hitCount + 1;

        switch (bodyPartIndex) {
            case 0:
                defendedBodyPart = BodyPart.ARM;
                break;
            case 1:
                defendedBodyPart = BodyPart.CHEST;
                break;
            case 2:
                defendedBodyPart = BodyPart.HEAD;
                break;
            case 3:
                defendedBodyPart = BodyPart.LEG;
                break;
        }
        return defendedBodyPart;
    }

    public int doDamage(BodyPart bodyPart) {
        switch (bodyPart.toString()) {
            case "нога": return 1;
            case "рука": return 1;
            case "голова": return 3;
            case "грудь": return 2;
        }
        return 0;
    }
}
