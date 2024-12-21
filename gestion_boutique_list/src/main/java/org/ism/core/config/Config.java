package org.ism.core.config;

import lombok.Getter;
import org.ism.repositories.*;
import org.ism.repositories.impl.*;
import org.ism.services.*;
import org.ism.services.impl.*;

public class Config {
    // Initialisation des repositories
    private static final IAdminRepository adminRepository = new AdminRepositoryImpl();
    private static final IArticleRepository articleRepository = new ArticleRepositoryImpl();
    private static final IBoutiquierRepository boutiquierRepository = new BoutiquierRepositoryImpl();
    private static final IClientRepository clientRepository = new ClientRepositoryImpl();
    private static final IDemandeRepository demandeRepository = new DemandeRepositoryImpl();
    private static final IDetailsDemandeRepository detailsDemandeRepository = new DetailsDemandeRepositoryImpl();
    private static final IDetteRepository detteRepository = new DetteRepositoryImpl();
    private static final IDetailsDetteArticleRepository detailsDetteArticleRepository = new DetailsDetteArticleRepositoryImpl();
    private static final IDetailsDettePaymentRepository detailsDettePaymentRepository = new DetailsDettePaymentRepositoryImpl();
    private static final IPaymentRepository paymentRepository = new PaymentRepositoryImpl();
    private static final IUserRepository userRepository = new UserRepositoryImpl();
    private static final IUserRepositorySecond userRepositorySecond = new UserRepositorySecondImpl();


    //
    @Getter
    private static final IAdminService adminService = new AdminServiceImpl(adminRepository);
    @Getter
    private static final IArticleService articleService = new ArticleServiceImpl(articleRepository);
    @Getter
    private static final IBoutiquierService boutiquierService = new BoutiquierServiceImpl(boutiquierRepository);
    @Getter
    private static final IClientService clientService = new ClientServiceImpl(clientRepository);
    @Getter
    private static final IDemandeService demandeService = new DemandeServiceImpl(demandeRepository);
    @Getter
    private static final IDetailsDemandeService detailsDemandeService = new DetailsDemandeServiceImpl(detailsDemandeRepository);
    @Getter
    private static final IDetteService detteService = new DetteServiceImpl(detteRepository);
    @Getter
    private static final IDetailsDetteArticleService detailsDetteArticleService = new DetailsDetteArticleServiceImpl(detailsDetteArticleRepository);
    @Getter
    private static final IDetailsDettePaymentService detailsDettePaymentService = new DetailsDettePaymentServiceImpl(detailsDettePaymentRepository);
    @Getter
    private static final IPaymentService paymentService = new PaymentServiceImpl(paymentRepository);
    @Getter
    private static final IUserService userService = new UserServiceImpl(userRepository);

    private Config() {}
}
