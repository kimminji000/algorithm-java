#include <iostream>
#include <queue>

using namespace std;

int K, W, H;
int map[200][200];
bool visited[200][200][31];
int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };
int hdx[8] = { 1, 1, 2, 2, -1, -1, -2, -2 };
int hdy[8] = { -2, 2, -1, 1, -2, 2, -1, 1 };

void dfs() {
    queue<pair<pair<int, int>, pair<int, int>>> q;
    q.push({ {0,0},{0,0} });
    visited[0][0][0] = true;

    while (!q.empty()) {
        int x = q.front().first.first;
        int y = q.front().first.second;
        int cnt = q.front().second.first;
        int k = q.front().second.second;
        q.pop();

        if (x == H - 1 && y == W - 1) {
            cout << cnt;
            return;
        }

        if (k < K) {
            for (int i = 0; i < 8; i++) {
                int nx = x + hdx[i];
                int ny = y + hdy[i];

                if (nx >= H || nx < 0 || ny >= W || ny < 0) continue;

                if (map[nx][ny] == 0 && visited[nx][ny][k + 1] == false) {
                    visited[nx][ny][k + 1] = true;
                    q.push(make_pair(make_pair(nx, ny), make_pair(cnt + 1, k + 1)));
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= H || nx < 0 || ny >= W || ny < 0) continue;

            if (map[nx][ny] == 0 && visited[nx][ny][k] == false) {
                visited[nx][ny][k] = true;
                q.push(make_pair(make_pair(nx, ny), make_pair(cnt + 1, k)));
            }
        }
    }
    cout << "-1";
    return;
}

int main()
{
    cin >> K;
    cin >> W >> H;

    for (int i = 0; i < H; i++) {
        for (int j = 0; j < W; j++) {
            cin >> map[i][j];
        }
    }

    dfs();
}