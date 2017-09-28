%{
t = 0 : 127;
a = sin(((8*pi)/127)*t)
rng default;
b = 0.1 * (randn(length(t),1));
b = b';
plot(a + b)
fprintf(fopen('C:\Users\GuiR\Documents\NetBeansProjects\WaveletTransform\src\io\github\guiritter\wavelet\test.txt', 'wt+'), '%f\n', (a + b));
%}
%
s1 = [0.3067160516210392, 0.5694274340352772, 1.0241126506874134, 1.3443033291307431, 1.8474458663908124, 1.3493421720534786, 0.9184256427441472, 0.41427264989376256, -0.07705837569336639, -0.49877261735233613, -1.1534997566157088, -1.1941004137778781, -1.2865574538451439, -1.1829691388284393, -0.8788835244334143, -0.3628730579693124, 0.07528707320649408, 0.6221372948252659, 1.1060896611507132, 1.3444871768938518, 1.3648412455903065, 1.2395808148370158, 0.7526006172745277, 0.34345449154436747, -0.08672664671253005, -0.8137766675556628, -1.3212459912098122, -1.268413093839897, -1.4113087677159806, -1.1130751690420553, -0.861976601295244, -0.15978845487863005, 0.39195211723882795, 0.6293108931204034, 1.2672697021747186, 1.392513162365261, 1.4255300992992046, 1.0034205849495514, 0.692121067172861, 0.21606354805936143, -0.18974998341106647, -0.689627101555616, -1.2025128631536544, -1.3473269177270968, -1.4358029466162825, -1.2102330549906493, -0.49472725945716794, -0.2420171953560325, 0.20206424800543016, 0.6860519696699368, 1.2095407974518675, 1.3628648821368903, 1.3391039729686787, 1.2025262981824971, 0.8059390959929913, -0.03695481459837134, -0.3582549435813831, -0.7948686322267347, -1.2672590955730005, -1.4979731890317662, -1.086756654646292, -1.0713558689520488, -0.7205891861834314, -0.0809997888917002];
d1 = [0.23067803101292503, 0.3436425819481631, -0.027133101407690208, 0.09409611358605618, -0.0727209826975681, 0.24220528575982814, -0.1654389451670918, -0.19959785955265152, -0.024521756064768283, -0.12069817780107536, -0.21802576937715407, 0.028678129724582835, 0.0575422285326177, -0.0020074761517886452, 0.035343318244047184, -0.008476796092864336, 0.15650960073426803, 0.4294238268942467, 0.006019600028240979, -0.18538784167792666, -0.032209420989828375, -0.07425328309239931, -0.05479936132839508, -0.08021277904423957, -0.13648433669106502, -0.05115776140528433, -0.07246571714955985, 0.07969871241431703, 0.10645492590763461, 0.17167562697715716, 0.19510985281246052, 0.17573371279438668, 0.033861929537461394, 0.16878214602854175, 0.3179830910724657, 0.1221972441771908, 0.047281402030819764, -0.12465231892147055, 0.017401190778219777, -0.13893658300821995, -0.21599920134227346, -0.015550692331854576, 0.03233882153078549, -0.09864988125689755, -0.065158475672778, 0.17098407654515668, 0.2512732231217644, 0.19857114050636865, 0.0046004367183996725, 0.01592970156657053, -0.05136918633285914, -0.02663246980661016, -0.09979185870851381, -0.06752657628297165, -0.2560504365354608, -0.04680056941961283, -0.3061623870113701, -0.1688641704151594, -0.3080942027375717, -0.08694726402826025, -0.10806712936874002, -0.08445824815848363, 0.13682304083925334, 0.04170303663403901];
s2 = [0.6195269999999999, 1.6747229999999997, 2.2604704999999994, 0.9423599999999999, -0.4071739999999999, -1.6600039999999996, -1.7462189999999995, -0.8780545, 0.49315349999999986, 1.7328194999999995, 1.8416044999999999, 0.7750279999999999, -0.6367519999999998, -1.8311654999999996, -1.7850089999999996, -0.722497, 0.7221419999999998, 1.8807504999999995, 1.7175274999999997, 0.6421835, -0.6218134999999999, -1.8030089999999994, -1.8710299999999997, -0.5209569999999999, 0.6279929999999998, 1.8189654999999996, 1.7972039999999998, 0.543754, -0.8153814999999999, -1.9553144999999996, -1.5260159999999996, -0.566809];
d2 = [0.18576499999999999, 0.22640899999999975, -0.35221250000000004, -0.35649, -0.29819699999999993, -0.028709000000000096, 0.07324799999999998, 0.36487450000000005, 0.38668149999999984, 0.16857250000000001, -0.08857249999999983, -0.28931000000000007, -0.5141019999999998, 0.03735849999999996, 0.21088299999999982, 0.49652199999999996, 0.167838, 0.08856049999999993, -0.2984764999999999, -0.3366235, -0.3534664999999999, -0.1023989999999999, 0.15950199999999992, 0.17869299999999996, 0.34223099999999995, 0.10841650000000003, -0.09657499999999986, -0.596016, -0.30873249999999997, -0.16313950000000021, 0.010890000000000066, 0.452258];
s3 = [1.6222797327372362, 2.2647431655411, -1.4617155817196446, -1.8556415875381547, 1.5740006030381621, 1.8502385846231086, -1.7450811996589506, -1.7730744964659546, 1.840522937449605, 1.6685676497404889, -1.7146084329237166, -1.691390228210066, 1.730260948632062, 1.6553072762728975, -1.959177930206442, -1.4798507493367359];
d3 = [0.7461362470809199, -0.9320448729031903, -0.8858845886739422, 0.6138850051354281, 0.8765762350064021, -0.7541834758042136, -0.8445778853907581, 0.7513094402920808, 0.8192599270903739, -0.7603830345082665, -0.8352313479570341, 0.9546457733968656, 0.8421447309566952, -0.8863229948782778, -0.8060543543983245, 0.6782617742616044];
s4 = [2.7485402499999987, -2.345725749999999, 2.4213027499999993, -2.487711749999999, 2.481301749999999, -2.408404749999999, 2.393958249999999, -2.4317604999999993];
d4 = [0.4542902499999999, -0.27854774999999976, 0.1953297500000004, -0.019794250000000346, -0.12159074999999975, 0.016417749999999787, -0.05300024999999975, 0.33893550000000006];
s5 = [0.28483286451026846, -0.04695825423181721, 0.05154596302815584, -0.026730227319109456];
d5 = [-3.602190033768067, -3.4711974418930875, -3.4575446241619376, -3.4122984522240682];
%}
%{
s1 = [0.13902143582196236, 0.6681869168432586, 1.094039147385732, 1.3507358795191973, 1.3985865025088722, 1.2301918509964207, 0.8715904250922561, 0.3782264675092159, -0.17361734219829536, -0.698617964278403, -1.1155995402508911, -1.3600916093410766, -1.3942915359199453, -1.2129108683710026, -0.8439941687428888, -0.34458232686036, 0.2081071825574504, 0.7286205050041482, 1.136476867965424, 1.3686150744814993, 1.389143091446126, 1.1948874236253388, 0.8158817244432552, 0.31072817549749165, -0.2424697436959919, -0.7581775684577459, -1.1566591097140504, -1.3763020322997783, -1.3831454117281017, -1.176132830467928, -0.7872707698628851, -0.276683105303703, 0.276683105303703, 0.7872707698628851, 1.176132830467928, 1.3831454117281017, 1.3763020322997783, 1.1566591097140504, 0.7581775684577459, 0.2424697436959919, -0.31072817549749165, -0.8158817244432552, -1.1948874236253388, -1.389143091446126, -1.3686150744814993, -1.136476867965424, -0.7286205050041482, -0.2081071825574504, 0.34458232686036, 0.8439941687428888, 1.2129108683710026, 1.3942915359199453, 1.3600916093410766, 1.1155995402508911, 0.698617964278403, 0.17361734219829536, -0.3782264675092159, -0.8715904250922561, -1.2301918509964207, -1.3985865025088722, -1.3507358795191973, -1.094039147385732, -0.6681869168432586, -0.13902143582196236];
d1 = [0.13902143582196236, 0.1229538484330604, 0.08787428101839578, 0.03920836391001281, -0.015519579633482383, -0.06784830986841173, -0.10968569679087609, -0.1345645417801435, -0.13863818394655922, -0.12127517693452355, -0.08516111229898304, -0.03588001229096771, 0.018949047522237028, 0.07084714972742368, 0.11179216789203072, 0.13545266789731386, 0.13816866504385136, 0.11952296633074333, 0.08239561767776249, 0.03252974036170586, -0.022366494595711717, -0.07380497739312708, -0.11383075674219162, -0.13625664830752296, -0.13761570754096353, -0.11769721662171961, -0.07957991847507762, -0.02915896233578963, 0.025770506640343638, 0.07671613601127203, 0.11579934202101494, 0.13697860433111442, 0.13697860433111442, 0.11579934202101494, 0.07671613601127203, 0.025770506640343638, -0.02915896233578963, -0.07957991847507762, -0.11769721662171961, -0.13761570754096353, -0.13625664830752296, -0.11383075674219162, -0.07380497739312708, -0.022366494595711717, 0.03252974036170586, 0.08239561767776249, 0.11952296633074333, 0.13816866504385136, 0.13545266789731386, 0.11179216789203072, 0.07084714972742368, 0.018949047522237028, -0.03588001229096771, -0.08516111229898304, -0.12127517693452355, -0.13863818394655922, -0.1345645417801435, -0.10968569679087609, -0.06784830986841173, -0.015519579633482383, 0.03920836391001281, 0.08787428101839578, 0.1229538484330604, 0.13902143582196236];
s2 = [0.5707824999999999, 1.7287169999999996, 1.8588269999999998, 0.8837539999999998, -0.6167634999999999, -1.7505779999999997, -1.8435704999999998, -0.8404504999999999, 0.6623664999999999, 1.7713674999999998, 1.8271854999999997, 0.7966334999999999, -0.7075644999999999, -1.7910739999999996, -1.8096829999999997, -0.7523289999999999, 0.7523289999999999, 1.8096829999999997, 1.7910739999999996, 0.7075644999999999, -0.7966334999999999, -1.8271854999999997, -1.7713674999999998, -0.6623664999999999, 0.8404504999999999, 1.8435704999999998, 1.7505779999999997, 0.6167634999999999, -0.8837539999999998, -1.8588269999999998, -1.7287169999999996, -0.5707824999999999];
d2 = [0.37417649999999986, 0.181512, -0.11907299999999987, -0.348861, -0.37123149999999994, -0.17288199999999998, 0.12825550000000008, 0.3531375, 0.3680585, 0.16414649999999997, -0.13735949999999997, -0.35719749999999995, -0.3646604999999999, -0.1553110000000001, 0.14638000000000007, 0.3610399999999999, 0.3610399999999999, 0.14638000000000007, -0.1553110000000001, -0.3646604999999999, -0.35719749999999995, -0.13735949999999997, 0.16414649999999997, 0.3680585, 0.3531375, 0.12825550000000008, -0.17288199999999998, -0.37123149999999994, -0.348861, -0.11907299999999987, 0.181512, 0.37417649999999986];
s3 = [1.6259916897850748, 1.9392976230533823, -1.6739632280343328, -1.897889449947098, 1.7209098150042608, 1.8553202075061055, -1.766804227083783, -1.8116160586813086, 1.8116160586813086, 1.766804227083783, -1.8553202075061055, -1.7209098150042608, 1.897889449947098, 1.6739632280343328, -1.9392976230533823, -1.6259916897850748];
d3 = [0.8187833371198541, -0.6894807304519104, -0.8017279215576347, 0.7093129543438493, 0.7841821274426622, -0.7287103075653586, -0.7661569149300452, 0.7476621835147205, 0.7476621835147205, -0.7661569149300452, -0.7287103075653586, 0.7841821274426622, 0.7093129543438493, -0.8017279215576347, -0.6894807304519104, 0.8187833371198541];
s4 = [2.5210402499999987, -2.525681249999999, 2.5287764999999993, -2.5303252499999993, 2.5303252499999993, -2.5287764999999993, 2.525681249999999, -2.5210402499999987];
d4 = [0.22154075000000018, -0.1583397499999999, 0.09504249999999992, -0.031686749999999986, -0.031686749999999986, 0.09504249999999992, -0.1583397499999999, 0.22154075000000018];
%}
%{
subplot(4, 2, 1); plot(s1);
subplot(4, 2, 2); plot(d1);
subplot(4, 2, 3); plot(s2);
subplot(4, 2, 4); plot(d2);
subplot(4, 2, 5); plot(s3);
subplot(4, 2, 6); plot(d3);
subplot(4, 2, 7); plot(s4);
subplot(4, 2, 8); plot(d4);
%}
%
subplot(5, 2, 1); plot(s1);
subplot(5, 2, 2); plot(d1);
subplot(5, 2, 3); plot(s2);
subplot(5, 2, 4); plot(d2);
subplot(5, 2, 5); plot(s3);
subplot(5, 2, 6); plot(d3);
subplot(5, 2, 7); plot(s4);
subplot(5, 2, 8); plot(d4);
subplot(5, 2, 9); plot(s5);
subplot(5, 2,10); plot(d5);
%}