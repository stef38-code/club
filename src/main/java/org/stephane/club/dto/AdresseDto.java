package org.stephane.club.dto;

import lombok.Builder;
import lombok.Value;
import org.stephane.club.share.validators.CodePostal;

@Value(staticConstructor = "of")
@Builder
public class AdresseDto {
    private final String id;
    /**
     * https://blog.bureaudeposte.net/bien-rediger-une-adresse-postale/
     */
    @CodePostal
    private final String codePostal;

}
