package graphs;

public class PrimsAlgorithm {
	static final long I = Long.MAX_VALUE;

	static long[][] costs = {
			{I, I, I, I, I, I, I, I},
			{I, I, 25, I, I, I, 5, I},
			{I, 25, I, 12, I, I, I, 10},
			{I, I, 12, I, 8, I, I, I},
			{I, I, I, 8, I, 16, I, 24},
			{I, I, I, I, 16, I, 20, 18},
			{I, 5, I, I, I, 20, I, I},
			{I, I, 10, I, 24, 18, I, I}
	};

	static long[] near = {I, I, I, I, I, I, I, I};
	static long[][] ans = new long[2][6];

	public static void main(String[] args) {
		int u = 0, v = 0, n = 8;
		long min = Long.MAX_VALUE;

		for (int i = 1; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (costs[i][j] < min) {
					min = costs[i][j] ;
					u = i ;
					v = j ;
				}
			}
		}

		ans[0][0] = u;
		ans[1][0] = v;
		near[u] = near[v] = 0;

		for (int i = 1; i < n; i++) {
			if (near[i] == 0) continue;
			if (costs[i][u] < costs[i][v]) near[i] = u;
			else near[i] = v;
		}

		int k = 0;

		for (int i = 1; i < n - 2; i++) {
			long min_curr = I;
			for (int j = 1; j < n; j++) {
				if (near[j] != 0 && costs[j][(int) near[j]] < min_curr) {
					min_curr = costs[j][(int) near[j]];
					k = j;
				}
			}

			ans[0][i] = k ;
			ans[1][i] = near[k] ;
			near[k] = 0 ;

			for (int j = 1; j < n; j++) {
				if (near[j] != 0 && costs[j][k] < costs[j][(int) near[j]]) {
					near[j] = k ;
				}
			}
		}

		for (int j = 0; j < ans[0].length; j++) {
			System.out.println(ans[0][j] + " " + ans[1][j]) ;
		}

	}

}
