package com.zhang.effective.article30_37;

import java.util.EnumMap;
import java.util.Map;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-08-18 14:03
 * @Version 1.0
 **/
public enum PhaseNew {

    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID), BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID), SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

        private final PhaseNew src;
        private final PhaseNew dst;

        Transition(PhaseNew src, PhaseNew dst) {
            this.src = src;
            this.dst = dst;
        }

        private static final Map<PhaseNew, Map<PhaseNew, Transition>> m = new EnumMap<>(PhaseNew.class);
        static {
            for(PhaseNew phaseNew : PhaseNew.values()){
                m.put(phaseNew, new EnumMap<>(PhaseNew.class));
            }
            for(Transition transition:Transition.values()){
                m.get(transition.src).put(transition.dst, transition);
            }
        }

        public static Transition from(Phase src, Phase dst) {
            return m.get(src).get(dst);
        }
    }

}
