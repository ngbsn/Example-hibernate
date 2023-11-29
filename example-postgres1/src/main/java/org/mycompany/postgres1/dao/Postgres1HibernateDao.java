package org.mycompany.postgres1.dao;

import org.mycompany.postgres1.dao.repository.*;
import org.mycompany.postgres1.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Set;

@Repository
public class Postgres1HibernateDao {

    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    InvoiceLineRepository invoiceLineRepository;
    @Autowired
    MediaTypeRepository mediaTypeRepository;
    @Autowired
    PlaylistRepository playlistRepository;
    @Autowired
    TrackRepository trackRepository;

    public void save(){

        Artist artist = Artist.builder()
                .name("MJ")
                .build();
        artist = artistRepository.save(artist);

        Album album = Album.builder()
                .title("Bad")
                .artistIdArtist(artist)
                .build();
        albumRepository.save(album);
        artist.setArtistIdAlbumSet(Set.of(album));

        Genre genre = Genre.builder()
                .name("Pop")
                .build();
        genreRepository.save(genre);

        MediaType mediaType = MediaType.builder()
                .name("CD")
                .build();
        mediaTypeRepository.save(mediaType);

        Playlist playlist = Playlist.builder()
                .name("playlist")
                .build();
        playlistRepository.save(playlist);

        Track track1 = Track.builder()
                .albumIdAlbum(album)
                .bytes(100)
                .composer("MJ")
                .genreIdGenre(genre)
                .mediaTypeIdMediaType(mediaType)
                .unitPrice(new BigDecimal("100.5"))
                .milliseconds(10000)
                .name("Thriller")
                .build();
        trackRepository.save(track1);

        Track track2 = Track.builder()
                .albumIdAlbum(album)
                .bytes(100)
                .composer("MJ")
                .genreIdGenre(genre)
                .mediaTypeIdMediaType(mediaType)
                .unitPrice(new BigDecimal("100.5"))
                .milliseconds(10000)
                .name("Dangerous")
                .build();
        trackRepository.save(track2);

        playlist.setTrack(Set.of(track1, track2));
        playlistRepository.save(playlist);

        album.setAlbumIdTrackSet(Set.of(track1, track2));
        genre.setGenreIdTrackSet(Set.of(track1, track2));
        mediaType.setMediaTypeIdTrackSet(Set.of(track1, track2));

        Employee manager = Employee.builder()
                .address("DEL, KAR, IN")
                .fax("44444")
                .city("BLR")
                .email("manager@gmail.com")
                .phone("77777777")
                .lastName("S")
                .firstName("N")
                .state("KAR")
                .country("IN")
                .postalCode("4353453")
                .birthDate(Timestamp.from(Instant.now()))
                .hireDate(Timestamp.from(Instant.now()))
                .title("Manager")
                .build();
        employeeRepository.save(manager);

        Employee employee = Employee.builder()
                .address("MYS, KAR, IN")
                .fax("55555")
                .city("BLR")
                .email("associate@gmail.com")
                .phone("888888888")
                .lastName("S")
                .firstName("N")
                .state("KAR")
                .country("IN")
                .postalCode("4353453")
                .birthDate(Timestamp.from(Instant.now()))
                .hireDate(Timestamp.from(Instant.now()))
                .title("Associate")
                .reportsToEmployee(manager)
                .build();
        employeeRepository.save(employee);

        manager.setReportsToEmployeeSet(Set.of(employee));

        Customer customer = Customer.builder()
                .fax("55555")
                .address("BLR, KAR, IN")
                .city("BLR")
                .email("customer@gmail.com")
                .phone("9999999999")
                .company("ngbsn")
                .lastName("Srinivasa")
                .firstName("Nagabhushan")
                .state("KAR")
                .country("IN")
                .postalCode("5123123")
                .supportRepIdEmployee(employee)
                .build();
        customerRepository.save(customer);

        employee.setSupportRepIdCustomerSet(Set.of(customer));

        Invoice invoice = Invoice.builder()
                .billingAddress("BLR, KAR, IN")
                .billingCity("BLR")
                .billingCountry("India")
                .billingPostalCode("5123123")
                .invoiceDate(Timestamp.from(Instant.now()))
                .total(new BigDecimal("201"))
                .customerIdCustomer(customer)
                .billingState("KAR")
                .build();
        invoiceRepository.save(invoice);

        customer.setCustomerIdInvoiceSet(Set.of(invoice));

        InvoiceLine invoiceLine = InvoiceLine.builder()
                .invoiceIdInvoice(invoice)
                .build();
        invoiceLineRepository.save(invoiceLine);

        invoice.setInvoiceIdInvoiceLineSet(Set.of(invoiceLine));
        track1.setTrackIdInvoiceLineSet(Set.of(invoiceLine));
        track2.setTrackIdInvoiceLineSet(Set.of(invoiceLine));
    }
}
