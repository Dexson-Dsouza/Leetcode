class Solution {
    private class Region {
        // Using Set<Integer> instead of List<int[]> (int[] -> row and col pair),
        // as need to de-dupe the elements.
        // If N rows and M cols.
        // Total elements = NxM.
        // Given row and col calculate X as: X = row * M + col.
        // Given X calculate row and col as: row = X / M and col = X % M.

        // Infected nodes represented by 1.
        Set<Integer> infected = new HashSet<>();

        // Uninfected neighbors represented by 0 are the ones this region can infect if not contained.
        Set<Integer> uninfectedNeighbors = new HashSet<>();

        // Number of walls required to contain all the infected nodes (1s) in this region.
        // Note that two infected 1s can infect the same 0, so in this case we need two walls to save one 0 from two 1s.
        int wallsRequired = 0;
    }
    
    public int containVirus(int[][] grid) {
    if (grid == null || grid.length == 0) {
        return 0;
    }

    int rows = grid.length;
    int cols = grid[0].length;

    int result = 0;

    while (true) {
        List<Region> regions = new ArrayList<>();

        // Find all the regions using DFS (or can also use BFS).
        boolean[][] visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1 && !visited[row][col]) {
                    Region region = new Region();
                    dfs(grid, row, col, visited, region);

                    // Add region to list of regions only if it can cause infection.
                    if (region.uninfectedNeighbors.size() > 0) {
                        regions.add(region);
                    }
                }
            }
        }

        // No more regions that can cause further infection, we are done.
        if (regions.size() == 0) {
            break;
        }

        // Sort the regions. Region which can infected most neighbors first.
        regions.sort(new Comparator<Region>() {
            @Override
            public int compare(Region o1, Region o2) {
                return o2.uninfectedNeighbors.size() - o1.uninfectedNeighbors.size();
            }
        });

        // Build wall around region which can infect most neighbors.
        Region regionThatCauseMostInfection = regions.remove(0);
        result += regionThatCauseMostInfection.wallsRequired;
        System.out.println(result);
        for (int neighbor : regionThatCauseMostInfection.infected) {
            int row = neighbor / cols;
            int col = neighbor % cols;

            // Choosing 2 as to denote that this cell is now contained
            // and will not cause any more infection.
            grid[row][col] = 2;
        }

        // For remaining regions, expand (neighbors are now infected).
        for (Region region : regions) {
            for (int neighbor : region.uninfectedNeighbors) {
                int row = neighbor / cols;
                int col = neighbor % cols;
                grid[row][col] = 1;
            }
        }
    }

    return result;
}

private void dfs(int[][] grid, int row, int col, boolean[][] visited, Region region) {
    int rows = grid.length;
    int cols = grid[0].length;

    if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 2) {
        return;
    }
    if (grid[row][col] == 0) {
        // If 0 it is uninfected neighbor, we need a wall.
        // Remeber we can reach this 0 multiple times from different infected neighbors i.e. 1s,
        // and this will account for numbers of walls need to be built around this 0.
        region.wallsRequired++;

        // Add to uninfected list, it will be de-duped as we use Set.
        region.uninfectedNeighbors.add(row * cols + col);
        return;
    }
    if(visited[row][col] == true){
        return;
    }
    
    visited[row][col] = true;
    
    if (grid[row][col] == 1) {
        // 1 is already infected.
        // Add to the list, since we are using Set it will be deduped if added multiple times.
        region.infected.add(row * cols + col);

    }

    

    

    // Visit neighbors.
    dfs(grid, row + 1, col, visited, region);
    dfs(grid, row - 1, col, visited, region);
    dfs(grid, row, col + 1, visited, region);
    dfs(grid, row, col - 1, visited, region);
}
}