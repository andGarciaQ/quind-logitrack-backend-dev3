package co.com.quind.logitrack.domain.usecase;

import co.com.quind.logitrack.domain.model.Package;
import co.com.quind.logitrack.domain.model.ports.inbound.PackageHandler;
import co.com.quind.logitrack.domain.model.ports.outbound.PackageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class PackageHandlerUseCase implements PackageHandler {

    private final PackageRepository packageRepository;

    @Override
    public Package createPackage(final Package packageModel) {

        log.debug("packageModel={}", packageModel);
        final var packageToSave = Package.createPackageFirstTime(packageModel);
        log.debug("packageToSave={}", packageToSave);

        return packageRepository.save(packageToSave);
    }

}
