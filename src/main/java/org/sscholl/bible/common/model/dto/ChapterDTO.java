package org.sscholl.bible.common.model.dto;

import java.util.Collection;
import java.util.TreeMap;

/**
 * Created by Simon on 01.10.2017.
 */
public class ChapterDTO {

    private Integer id;
    private Integer number;
    private BookDTO bookDTO;
    private TreeMap<Integer, VerseDTO> verses = new TreeMap<>();

    public ChapterDTO() {
    }

    public ChapterDTO(Integer number) {
        this.number = number;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BookDTO getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(BookDTO bookDTO) {
        this.bookDTO = bookDTO;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Collection<VerseDTO> getVerses() {
        return verses.values();
    }

    public VerseDTO getFirstVerse() {
        if (verses.firstEntry() != null) {
            return verses.firstEntry().getValue();
        }
        return null;
    }

    public VerseDTO getLastVerse() {
        if (verses.lastEntry() != null) {
            return verses.lastEntry().getValue();
        }
        return null;
    }

    public VerseDTO getVerse(int number) {
        return verses.get(number);
    }

    public VerseDTO getOrCreateVerse(int number) {
        VerseDTO obj = getVerse(number);
        if (obj == null) {
            obj = new VerseDTO(number);
            verses.put(number, obj);
        }
        return obj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChapterDTO chapterDTO = (ChapterDTO) o;

        return number == chapterDTO.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return "ChapterDTO{" +
                "number=" + number +
                ", versesSize=" + verses.size() +
                '}';
    }
}
