package EPICODE.SpringWebService.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Blog {
    private Integer id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private Integer tempoDiLettura;
}
