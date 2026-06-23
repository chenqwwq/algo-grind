package template.reservoir_sampling;


import java.util.Random;

/**
 * @author 沽酒
 * @since 2023/06/13
 */
public class ReservoirSampling {

    Random random = new Random();

    public int sample(int[] streams) {
        // streams 类比为未知大小的数据流
        int ans = 0, cnt = 0;
        for (int num : streams) {
            // 每次都有 1 / cnt 的概率保留元素
            if (random.nextInt(++cnt) == 0) ans = num;
        }
        return ans;
    }
}
