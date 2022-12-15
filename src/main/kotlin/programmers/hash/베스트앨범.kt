package programmers.hash

class 베스트앨범 {
    fun solution(genres: Array<String>, plays: IntArray): List<Int> {
        val genreMap = HashMap<String, GenreSongs>().toMutableMap()
        val result = ArrayList<Int>()

        genres.indices.forEach { i ->
            genreMap.putIfAbsent(genres[i], GenreSongs())
            genreMap[genres[i]]!!.add(Song(i, plays[i]))
        }

        genreMap.values.sortedByDescending { g -> g.totalCount }
            .map { it.peekTwo() }
            .flatten()
            .mapTo(result) { it.id }

        return result
    }

    class GenreSongs {
        private val list = ArrayList<Song>()
        var totalCount = 0

        fun add(song: Song) {
            list.add(song)
            totalCount += song.play
        }

        fun peekTwo(): List<Song> {
            if (list.size == 1) {
                return list.subList(0, 1)
            }

            return list.sortedByDescending { s -> s.play }.subList(0, 2)
        }
    }

    class Song(val id: Int, val play: Int)
}
