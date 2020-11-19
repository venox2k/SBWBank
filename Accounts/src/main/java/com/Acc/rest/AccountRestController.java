package com.Acc.rest;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Acc.entity.Account;
import com.Acc.service.AccountService;
import com.Acc.service.SequenceGenerator;

@RestController
@RequestMapping("/Accounts")
public class AccountRestController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private SequenceGenerator sequenceGenerator;

	/*------ Create Account -------------------------------------------------------------*/

	@PostMapping("/Create")
	@ResponseBody
	public Account insertAccount(@RequestBody Account acc) {

		acc.setId(Long.toString(sequenceGenerator.generateSequence(Account.SEQUENCE_NAME)));
		accountService.insertAccount(acc);
		return acc;

	}

	/*------ Delete Account -------------------------------------------------------------*/

	@GetMapping("/Delete")
	@ResponseBody
	public String DeleteAccount(@RequestBody String uuid) {

		List<Account> accs = accountService.getAllAccounts(uuid);
		System.out.println(uuid);
		for (int  i=0 ; i<accs.size() ;i++) {
			System.out.println("ui" +accs.get(i).getId());
			accountService.deleteAccount(accs.get(i).getId());
		}
		return "uuid est  : "+uuid ;
        
	}

	/*------ Deposit -------------------------------------------------------------------*/

	@PostMapping("/deposit/id={id}&amount={amount}")
	@ResponseBody
	public Account deposit(@PathVariable String id, @PathVariable int amount) {
		System.out.println(accountService.getAccount(id));
		accountService.deposit(id, amount);
		return accountService.getAccount(id);

	}

	/*------ Withdraw  -------------------------------------------------------------*/

	@PostMapping("/withdraw/id={id}&amount={amount}")
	@ResponseBody
	public Account withdraw(@PathVariable String id, @PathVariable int amount) {
		System.out.println(accountService.getAccount(id));
		accountService.withdraw(id, amount);
		return accountService.getAccount(id);

	}

	/*------ get Account -------------------------------------------------------------*/

	@GetMapping("/get")
	@ResponseBody
	public Account get(@RequestBody String id) {
		System.out.println(accountService.getAccount(id));
		return accountService.getAccount(id);

	}

	@GetMapping("/MyAccounts/{id}")
	@ResponseBody
	public List<Account> getAll(@PathVariable String id) {
		return accountService.getAllAccounts(id);

	}

}
