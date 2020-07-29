package comp1110.ass1;

/*
 * IMPORTANT: THIS CODE MUST NOT BE MODIFIED.
 *
 * You may write your own tests, but they need to be in separate files.
 */
public class SampleSolution {

        public Objective obj;
        public int setLength;
        public String exampleString;

        public final static SampleSolution[] SOLUTIONS = new SampleSolution[]{
            new SampleSolution(Objective.getObjective(1), 4, "◇SpWpWNEpEpN◇NpWpWW"),
            new SampleSolution(Objective.getObjective(2), 1, "□EpSE□W+NpWWNW"),
            new SampleSolution(Objective.getObjective(3), 12, "+W△SpS□S*ExEpN◇NpWpW"),
            new SampleSolution(Objective.getObjective(4), 28, "pNE*SpE□SpS◇WpW○WpNpWpW"),
            new SampleSolution(Objective.getObjective(5), 14, "pNpNWWSpS*EpE□SpN+W=WpNWW"),
            new SampleSolution(Objective.getObjective(6), 4, "pWpS*S○ExEpN◇NpWpW"),
            new SampleSolution(Objective.getObjective(7), 7, "○E◇EpWpN*NxW△WpSpWpNpNW"),
            new SampleSolution(Objective.getObjective(8), 28, "pEpN*N+NxWpE△S○S*EpW+NpWW"),
            new SampleSolution(Objective.getObjective(9), 24, "pWpN=EpE△SxS◇E+NpWpWW"),
            new SampleSolution(Objective.getObjective(10), 4, "pWpNpE△EpE*S=S□WpWNWW"),
            new SampleSolution(Objective.getObjective(11), 2, "=N□E○SpE△SpNpW△N○NpEpNpWpW"),
            new SampleSolution(Objective.getObjective(12), 27, "△NpN*E=S□SpW+W◇WxN○NpEpNpWpWW"),
            new SampleSolution(Objective.getObjective(13), 2, "○E◇E=S+W△S*E+NpWpWW"),
            new SampleSolution(Objective.getObjective(14), 1, "pSpS◇E△S+W□WxN◇E△E+S□WpNNW"),
            new SampleSolution(Objective.getObjective(15), 2, "pSxS△E*E◇S+W□W△N*E◇EpNpNWW"),
            new SampleSolution(Objective.getObjective(16), 2, "*NpSW△W□S=WxS◇E=N□NpENWW"),
            new SampleSolution(Objective.getObjective(17), 2, "◇W+S□E◇N+W□S*S△ExE=N◇WpNpNW"),
            new SampleSolution(Objective.getObjective(18), 32, "△E+S*WxWpWpN◇N△EpExS*EpW+NpWW"),
            new SampleSolution(Objective.getObjective(19), 1, "pE◇S+S=W□WxN○N△E◇E+S=S□WpWNW"),
            new SampleSolution(Objective.getObjective(20), 40, "◇WpWNE△N*E=EpE□S◇W○SxEpWpN◇NpWpW"),
            new SampleSolution(Objective.getObjective(21), 12, "pS□E◇N*E=S◇W□W+N*E=E◇SpN□WpNW"),
            new SampleSolution(Objective.getObjective(22), 1, "pEpNpWxN○N△E+E*S=S□WpWNW"),
            new SampleSolution(Objective.getObjective(23), 15, "pEpN◇N△WpExS◇E=SpW□WpWNW"),
            new SampleSolution(Objective.getObjective(24), 124, "pSpE△SxS+WpW○W□N◇E○S□W◇N*N=EpS○S*WpEpNpNWW"),
            new SampleSolution(Objective.getObjective(25), 84, "pS*E○EpExSpS◇SpWpN□WpNW"),
            new SampleSolution(Objective.getObjective(26), 6, "○W*WxS◇SpS=E□E+N△W◇WpNpNWW"),
            new SampleSolution(Objective.getObjective(27), 20, "pWpS◇N○EpExN*E□S+S=WpWpWNNW"),
            new SampleSolution(Objective.getObjective(28), 10, "+E*S=E○N*W=S○E□SpW◇W△WpNpWpW"),
            new SampleSolution(Objective.getObjective(29), 129, "pWWNExWpE◇N□ExS◇WpN□N+N=ExS+W□S◇EpW+NpWW"),
            new SampleSolution(Objective.getObjective(30), 2, "*E○S□W*N○E=N+W◇W△S○EpS◇NpWpWNW"),
            new SampleSolution(Objective.getObjective(31), 29, "pE+N◇NpNxWpWpW*S□S=WpENWW"),
            new SampleSolution(Objective.getObjective(32), 12, "◇N△WxS◇E□E*N△WxW+NpN○E=E△S*S□W◇W+N○N=E△E*S□S◇W+W○NpSxE□E◇S+W□N◇EpNpNWW"),
            new SampleSolution(Objective.getObjective(33), 48, "pS△E□ExN*N+WpE○S*ExS□W*N○N+ExS□S*W△WpWpNpWpW"),
            new SampleSolution(Objective.getObjective(34), 792, "*WxW□S=E+EpW*NpN△NpW○WxS+S=W□NpS+E△E*SpN=WpNW"),
            new SampleSolution(Objective.getObjective(35), 8, "pNpW◇WpSxS△E+S*W=W○N△E+E*S=WpNpNW"),
            new SampleSolution(Objective.getObjective(36), 10449, "pNxW+NpW□E=E◇SpS*S○W△WpNpW+N□N=ExS□W+S△EpSpS○E*N□W+W△S○E*E□N+WpNNW"),
            new SampleSolution(Objective.getObjective(37), 168, "△WpE*WpS+S○ExEpN△N=N◇W□W+S*E=E◇N□W=S*WpS○SxE△E◇NpNpWpW"),
            new SampleSolution(Objective.getObjective(38), 540, "○SxWpEpN*N○E△E◇S=S+W□W*NpSxEpE△N◇E=S+SpW□WpWNNW"),
            new SampleSolution(Objective.getObjective(39), 415, "pEpN△E◇E+S*S□W=W○N△NpE◇EpNxS*E+NxW◇W△S*E=S□E+N=W◇NxE=S◇W*W△NxE*S◇E=NpSpW*WpWS◇S=E+S□WpNNW"),
            new SampleSolution(Objective.getObjective(40), 6, "=W○N*ExE□S=WxN*W○SpNxE=E□N+N△W◇W○SxS=E□E+NpNWW"),
            new SampleSolution(Objective.getObjective(41), 5, "△E◇S□W△N◇E*NpE=EpExS*W=NpWNWW"),
            new SampleSolution(Objective.getObjective(42), 80, "○WpS*W□SxEpE△E○NpESWW*W□WxS△E○E*N□W+N=WxS△S○E+N□E*SpENW+W□N=NpENWW"),
            new SampleSolution(Objective.getObjective(43), 36, "pExS+E□NxW+S△S=E□NxN+W△SxE+N△WpW◇W○SpS*S=E□E+NxW*WpNpNWW"),
            new SampleSolution(Objective.getObjective(44), 121014, "=WxS+E=NxW◇NpS*ExSpE○E□SpN=W+W◇N*NxE△E□S=SpS+W◇W*N○E◇S+EpEpNpW=N□NpWNW"),
            new SampleSolution(Objective.getObjective(45), 2, "*S◇W△N*E◇SxE□N◇WxSpNpExN◇E=NpWpWNW"),
            new SampleSolution(Objective.getObjective(46), 15246, "○W◇WpWpS+N□E=E○S*SxW△W+N□N=E○E*SpN◇WpW□W+SpSpS△ExE◇N□W+W△SxE◇E□N+WpNNW"),
            new SampleSolution(Objective.getObjective(47), 17, "+W□SxW○N□E+E*SxW+N□W○S+EpWNW□N=N◇W○S+S□E=N◇N△EpE*SxS=W□W+N○N△E*ExS=S□WpWNW"),
            new SampleSolution(Objective.getObjective(48), 7, "xN=W+W*S△E+N=EpNE=W+SxE=N○N◇W+S○E=SxW○N+NpWWS+S*W△S○ExE=N*W+N□W△S○SxE+N*E=SpNEpEpN+W*NpWpWW"),
            new SampleSolution(Objective.getObjective(49), 1152, "□N+E*N○WpNE+S□SxE△E=N◇N○W+W□SxSpE△E*N◇E○N+W◇S○E=S*WpW△WpNxN○E=E+N◇WpE=S△S*EpW+NpWW"),
            new SampleSolution(Objective.getObjective(50), 56, "pEpN△E=N○E*S=W○NpSpE○SxS□WpW△NpSxEpE○N*E=S+S□WpWpWNNW"),
            new SampleSolution(Objective.getObjective(52), 56, "□E=NxE+N○WxS+E*S=W□W◇N+ExN○E*S=SpW□WpN◇W+N△N○EpExS◇SpWpWNW"),
            new SampleSolution(Objective.getObjective(54), 8, "pS△SxE◇E+S=W□WpNpNWSS□E=E+N◇W=S□WxN=E◇E+S□WpNNW"),
        };

        public SampleSolution(Objective obj, int setLength, String exampleString) {
            this.obj = obj;
            this.setLength = setLength;
            this.exampleString = exampleString;
        }

    }

