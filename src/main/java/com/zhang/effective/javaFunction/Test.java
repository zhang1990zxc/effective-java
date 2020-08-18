package com.zhang.effective.javaFunction;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author zhang
 * @Description 在公有类使用访问方法而非公有域
 * @Date 2020-07-13 11:43
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) {
        BinaryOperator<Long> addLong = Long::sum;
        System.out.println(addLong.apply(3L, 5L));

        List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());
        System.out.println(collected);

        List<String> collected1 = Stream.of("a", "b", "hello").map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collected1);

        List<String> beginningWithNumber = Stream.of("a", "1abc", "abc1").filter(value -> Character.isDigit(value.charAt(0))).collect(Collectors.toList());
        System.out.println(beginningWithNumber);

        List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)).flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(together);

        List<Track> tracks = Arrays.asList(new Track("Bakai", 524),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));
        Track shortest = tracks.stream().min(Comparator.comparing(Track::getLength)).get();
        System.out.println(shortest);

        int count = Stream.of(1, 2, 3).reduce(0, Integer::sum);
        System.out.println(count);

       /* Album album = new Album();
        Set<String> origins = album.getMusicians().filter(artist -> artist.getName().startsWith("The"))
                .map(Artist::getNationality).collect(Collectors.toSet());

        Optional<String> a = Optional.of("a");
        System.out.println(a.get());

        List<Artist> artists = new ArrayList<>();
        StringBuilder builder = new StringBuilder("[");
        for (Artist artist : artists) {
            if (builder.length() > 1)
                builder.append(", ");
            String name = artist.getName();
            builder.append(name);
        }
        builder.append("]");
        String result = builder.toString();
        String result1 = artists.stream().map(Artist::getName)
                .collect(Collectors.joining(",", "[", "]"));*/

//        List<Album> albums = new ArrayList<>();
//        Map<Artist, List<Album>> albumsByArtist = albums.stream()
//                .collect(Collectors.groupingBy(Album::getMainMusician));
//        Map<Artist, Integer> numberOfAlbums = new HashMap<>();
//        for (Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
//            numberOfAlbums.put(entry.getKey(), entry.getValue().size());
//        }

        Map<Artist, List<Album>> albumsByArtist = new HashMap<>();
        Map<Artist, Integer> countOfAlbums = new HashMap<>();
        albumsByArtist.forEach((artist, albums) -> countOfAlbums.put(artist, albums.size()));

        System.out.println(Arrays.toString(parallelInitialize(5)));

    }

    public static double[] parallelInitialize(int size) {
        double[] values = new double[size];
        Arrays.parallelSetAll(values, i -> i);
        return values;
    }

    // 串行化
    public int serialArraySum(List<Album> albums) {
        return albums.stream().flatMap(Album::getTracks).mapToInt(Track::getLength).sum();
    }

    // 并行化
    public int serialArraySum2(List<Album> albums) {
        return albums.stream().flatMap(Album::getTracks).mapToInt(Track::getLength).sum();
    }

    public Map<Artist, List<String>> nameOfAlbumsDumb2(Stream<Album> albums) {
        return albums.collect(Collectors.groupingBy(Album::getMainMusician,
                Collectors.mapping(Album::getName, Collectors.toList())));
    }

    public Map<Artist, List<String>> nameOfAlbumsDumb(Stream<Album> albums) {
        Map<Artist, List<Album>> albumsByArtist = albums.collect(Collectors.groupingBy(Album::getMainMusician));
        Map<Artist, List<String>> nameOfAlbums = new HashMap<>();
        for (Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            nameOfAlbums.put(entry.getKey(), entry.getValue().stream().map(Album::getName).collect(Collectors.toList()));
        }
        return nameOfAlbums;
    }

    public Map<Artist, Long> numberOfAlbums(Stream<Album> albums) {
        return albums.collect(Collectors.groupingBy(Album::getMainMusician, Collectors.counting()));
    }

    /*public Set<String> findLongTracks(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        for (Album album : albums) {
            for (Track track : album.getTracks()) {
                if (track.getLength() > 60) {
                    String name = track.getName();
                    trackNames.add(name);
                }
            }
        }
        return trackNames;
    }*/

    /*public Set<String> findLongTracks(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .forEach(album ->
                        album.getTracks()
                                .forEach(track -> {
                                    if (track.getLength() > 60) {
                                        String name = track.getName();
                                        trackNames.add(name);
                                    }
                                })
                );
        return trackNames;
    }*/

    /*public Set<String> findLongTracks(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .forEach(album -> album.getTracks()
                        .filter(track -> track.getLength() > 60)
                        .map(track -> track.getName())
                        .forEach(name -> trackNames.add(name)));
        return trackNames;
    }*/

    /*public Set<String> findLongTracks(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream().flatMap(album -> album.getTracks())
                .filter(track -> track.getLength()>60)
                .map(track -> track.getName())
                .forEach(name -> trackNames.add(name));
        return trackNames;
    }*/

    public Set<String> findLongTracks(List<Album> albums) {
        return albums.stream().flatMap(Album::getTracks)
                .filter(track -> track.getLength() > 60)
                .map(Track::getName)
                .collect(Collectors.toSet());
    }

    public Optional<Artist> biggestGroup(Stream<Artist> artists) {
        Function<Artist, Long> getCount = artist -> artist.getMembers().count();
        return artists.max(Comparator.comparing(getCount));
    }

    public double averageNumberOfTracks(List<Album> albums) {
        return albums.stream().collect(Collectors.averagingInt(album -> album.getTrackList().size()));
    }

    public Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists) {
        return artists.collect(Collectors.partitioningBy(Artist::isSolo));
    }

    public Map<Artist, List<Album>> albumsByArtist(Stream<Album> albums) {
        return albums.collect(Collectors.groupingBy(Album::getMainMusician));
    }

}
