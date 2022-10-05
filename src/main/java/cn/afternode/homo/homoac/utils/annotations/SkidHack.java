package cn.afternode.homo.homoac.utils.annotations;

public @interface SkidHack {
    class HackTypes{
        public enum LIQUID {
            FALSE,
            LIQUID_BOUNCE,
            FDP_CLIENT
        }

        public enum MOD{
            FALSE,
            WURST
        }
    }

    HackTypes.LIQUID liquidHack() default HackTypes.LIQUID.FALSE;
    HackTypes.MOD modHack() default HackTypes.MOD.FALSE;
}
