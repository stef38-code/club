package org.stephane.club.dto;

import lombok.Builder;
import lombok.Value;
import org.stephane.club.fields.CodePostal;
@Value(staticConstructor = "of")
@Builder
public class AdresseDto {
    private final String id;
    /**
     * https://blog.bureaudeposte.net/bien-rediger-une-adresse-postale/
     */
    private final CodePostal codePostal;
}
